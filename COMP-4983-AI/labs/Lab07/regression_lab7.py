import loaddata_lab7 as loader
import pandas as pd
import numpy as np
from sklearn.linear_model import LinearRegression, Ridge, Lasso
from sklearn.preprocessing import StandardScaler
import matplotlib.pyplot as plt
import random
import warnings


def verify(data, data_expected):
    data = data.reindex(sorted(data.columns), axis=1)
    data_expected = data.reindex(sorted(data_expected.columns), axis=1)
    print('Part1) 4. np.allclose(data, data_expected) -> ', end='')
    print(np.allclose(data, data_expected))


def linear_regression(data):
    # Shuffle the data
    nrows = data.shape[0]
    shuffled_indices = list(range(nrows))
    random.seed(42)
    random.shuffle(shuffled_indices)

    # Split the data into train and test data set
    num_train_samples = int(nrows * TRAIN_RATIO)
    train_indices = shuffled_indices[:num_train_samples]
    test_indices = shuffled_indices[num_train_samples:]

    train_data = data.iloc[train_indices, :]
    test_data = data.iloc[test_indices, :]

    # Divide data set into features and the label to predict 
    train_features = train_data.drop('TARGET_D', axis=1, inplace=False)
    train_labels = train_data.loc[:, 'TARGET_D']

    test_features = test_data.drop('TARGET_D', axis=1, inplace=False)
    test_labels = test_data.loc[:, 'TARGET_D']

    # Fit the model using a linear regression
    lin_reg = LinearRegression()
    lin_reg.fit(train_features, train_labels)

    # Predict labels on train and test data set
    train_preds = lin_reg.predict(train_features)
    preds = lin_reg.predict(test_features)

    # Calculate Mean Absolute Errors on test and data set
    train_mae = np.mean(np.abs(train_labels - train_preds))
    mae = np.mean(np.abs(test_labels - preds))

    print('Part1) 5. Train MAE:', train_mae)
    print('Part1) 5. Test MAE:', mae)


def ridge_regression(data):
    # Normalize features except for TARGET_D, which is the label to predict
    features = data.drop('TARGET_D', inplace=False, axis=1)
    labels = data['TARGET_D']
    scaling = StandardScaler(True, False, False)
    normalized_features = scaling.fit_transform(features)
    data = pd.DataFrame(normalized_features, columns=features.columns)
    labels = pd.DataFrame(labels, columns=['TARGET_D'])
    data = pd.concat([data, labels], axis=1)

    # Shuffle the data
    nrows = data.shape[0]
    shuffled_indices = list(range(nrows))
    random.seed(42)
    random.shuffle(shuffled_indices)

    # Split the data into test and train data set
    num_train_samples = int(nrows * TRAIN_RATIO)
    train_indices = shuffled_indices[:num_train_samples]
    test_indices = shuffled_indices[num_train_samples:]

    train_data = data.iloc[train_indices, :]
    test_data = data.iloc[test_indices, :]

    # Split the data into features and the label to predict
    train_features = train_data.drop('TARGET_D', axis=1, inplace=False)
    train_labels = train_data.loc[:, 'TARGET_D']

    test_features = test_data.drop('TARGET_D', axis=1, inplace=False)
    test_labels = test_data.loc[:, 'TARGET_D']

    # Perform a 5-fold cross validation
    K = 5
    len_subset = int(train_features.shape[0] / K)
    sum_cv_error = 0
    lowest_cv_error = 100
    selected_alpha = 0
    alpha_vs_cv_error_dict = {}
    alpha_vs_training_error_dict = {}

    # Perform cross validation for specific ridge alpha values 10^-3, 10^-2 ... 10^10
    for i in range(-3, 11):
        sum_cv_error = 0
        sum_training_error = 0
        # 5-fold cross validation
        for k in range(K):
            # Split the training data set into one for training and the other for validation
            validation_test_features = train_features[len_subset *
                                                      k: len_subset * (k + 1)]
            validation_test_labels = train_labels[len_subset *
                                                  k: len_subset * (k + 1)]
            validation_train_featues = np.concatenate(
                (train_features[0: len_subset * k], train_features[len_subset * (k + 1):]))
            validation_train_labels = np.concatenate(
                (train_labels[0: len_subset * k], train_labels[len_subset * (k + 1):]))

            # Fit a model using ridge regression with an alpha value of 10^i
            ridge = Ridge(alpha=10 ** i)
            ridge.fit(validation_train_featues, validation_train_labels)

            # Predict the labels with the model
            preds = ridge.predict(validation_test_features)
            training_preds = ridge.predict(validation_train_featues)

            # Calculate Mean Absolute Errors on training set and validation set
            training_error = np.mean(
                np.abs(training_preds - validation_train_labels))
            cv_error = np.mean(np.abs(preds - validation_test_labels))
            sum_cv_error += cv_error
            sum_training_error += training_error

        # Calculate the mean MAE
        mean_cv_error = sum_cv_error / K
        mean_training_error = sum_training_error / K
        alpha_vs_cv_error_dict[i] = mean_cv_error
        alpha_vs_training_error_dict[i] = mean_training_error

        # Find the ridge alpha value that yields the lowest mean MAE
        if lowest_cv_error > mean_cv_error:
            lowest_cv_error = mean_cv_error
            selected_alpha = i
        print('ridge alpha= 10**' + str(i) + ': ', mean_cv_error)

    print('Part2) 5, ridge alpha= 10**' + str(selected_alpha) +
          ': ', alpha_vs_cv_error_dict[selected_alpha])
    plt.plot(range(-3, 11), [alpha_vs_cv_error_dict[i]
                             for i in range(-3, 11)], label='CV Error')
    plt.plot(range(-3, 11), [alpha_vs_training_error_dict[i]
                             for i in range(-3, 11)], label='Training Error')
    plt.suptitle('Ridge Alpha vs. CV Error & Training Error (MAE)')
    plt.xlabel('Power of alpha value (10^x)')
    plt.ylabel('MAE')
    plt.legend()
    plt.show()

    ridge = Ridge(alpha=10**selected_alpha)
    ridge.fit(train_features, train_labels)
    preds = ridge.predict(test_features)
    mae = np.mean(np.abs(preds - test_labels))
    print('Part2) 6.  MAE:', mae)
    print('Part2) 7. Got lower MAE compared to regular linear regression')


def the_lasso(data):
    # Normalize features except for TARGET_D, which is the label to predict.
    features = data.drop('TARGET_D', inplace=False, axis=1)
    labels = data['TARGET_D']
    scaling = StandardScaler(True, False, False)
    normalized_features = scaling.fit_transform(features)
    data = pd.DataFrame(normalized_features, columns=features.columns)
    labels = pd.DataFrame(labels, columns=['TARGET_D'])
    data = pd.concat([data, labels], axis=1)

    # Shuffle the data
    nrows = data.shape[0]
    shuffled_indices = list(range(nrows))
    random.seed(42)
    random.shuffle(shuffled_indices)

    # Split the data into one for training and the other for testing
    num_train_samples = int(nrows * TRAIN_RATIO)
    train_indices = shuffled_indices[:num_train_samples]
    test_indices = shuffled_indices[num_train_samples:]

    train_data = data.iloc[train_indices, :]
    test_data = data.iloc[test_indices, :]

    # Split the data sets into features and labels
    train_features = train_data.drop('TARGET_D', axis=1, inplace=False)
    train_labels = train_data.loc[:, 'TARGET_D']

    test_features = test_data.drop('TARGET_D', axis=1, inplace=False)
    test_labels = test_data.loc[:, 'TARGET_D']

    # Perform 5-fold cross validation
    K = 5
    len_subset = int(train_features.shape[0] / K)
    sum_cv_error = 0
    lowest_cv_error = 100
    selected_alpha = 0
    alpha_vs_cv_error_dict = {}
    alpha_vs_training_error_dict = {}

    # Perform cross validation on each lasso alpha value of 10^-2, 10^-1.75 ... 10^2
    for i in np.arange(-2.00, 2.25, 0.25):
        sum_cv_error = 0
        sum_training_error = 0
        # Perform 5-fold cross validation
        for k in range(K):
            # Split the training data set into one for training and the other for validation
            validation_test_features = train_features[len_subset *
                                                      k: len_subset * (k + 1)]
            validation_test_labels = train_labels[len_subset *
                                                  k: len_subset * (k + 1)]
            validation_train_features = np.concatenate(
                (train_features[0: len_subset * k], train_features[len_subset * (k + 1):]))
            validation_train_labels = np.concatenate(
                (train_labels[0: len_subset * k], train_labels[len_subset * (k + 1):]))

            # Fit a model with the lasso regression with an alpha value of 10^i
            lasso = Lasso(alpha=10 ** i, tol=0.5)
            lasso.fit(validation_train_features, validation_train_labels)

            # Predict the label using the model trained
            preds = lasso.predict(validation_test_features)
            training_preds = lasso.predict(validation_train_features)
            
            # Calculate Mean Absolute Errors on validation set and training set
            cv_error = np.mean(np.abs(preds - validation_test_labels))
            training_error = np.mean(
                np.abs(training_preds - validation_train_labels))
            sum_cv_error += cv_error
            sum_training_error += training_error
        
        # Caluclate the mean MAE
        mean_cv_error = sum_cv_error / K
        mean_training_error = sum_training_error / K
        alpha_vs_cv_error_dict[i] = mean_cv_error
        alpha_vs_training_error_dict[i] = mean_training_error

        # Find lasso alpha value that yields the lowest mean MAE
        if lowest_cv_error > mean_cv_error:
            lowest_cv_error = mean_cv_error
            selected_alpha = i
        print('lasso alpha= 10**' + str(i) + ': ', mean_cv_error)

    print('Part3) lasso alpha= 10**' + str(selected_alpha) +
          ': ', alpha_vs_cv_error_dict[selected_alpha])
    plt.plot(np.arange(-2.00, 2.25, 0.25), [alpha_vs_cv_error_dict[i]
                                            for i in np.arange(-2.00, 2.25, 0.25)], label='CV Error')
    plt.plot(np.arange(-2.00, 2.25, 0.25), [alpha_vs_training_error_dict[i]
                                            for i in np.arange(-2.00, 2.25, 0.25)], label='Training Error')
    plt.suptitle('Lasso Alpha vs. CV Error & Training Error (MAE)')
    plt.xlabel('Power of alpha value (10^x)')
    plt.ylabel('MAE')
    plt.legend()
    plt.show()

    print('Part3) 2. The best value is 10^{0}'.format(selected_alpha))

    lasso = Lasso(alpha=10**selected_alpha)
    lasso.fit(train_features, train_labels)
    coefs = lasso.coef_
    preds = lasso.predict(test_features)
    mae = np.mean(np.abs(preds - test_labels))
    print('Part3) 3. MAE:', mae)
    print('Part3) 4. Got lower MAE compared to regular linear regression')
    print('Part3) 5. The most suitable model is either lasso or ridger regression model as both yield similar MAE on test data set')
    print('Part3) 6. The three best features are ')

    # Find the three features that have the biggest effect on prediction.
    first_best_index = 0
    second_best_index = 0
    third_best_index = 0

    for i in range(len(coefs)):
        if abs(coefs[i]) > abs(coefs[first_best_index]):
            third_best_index = second_best_index
            second_best_index = first_best_index
            first_best_index = i
        elif abs(coefs[i]) > abs(coefs[second_best_index]):
            third_best_index = second_best_index
            second_best_index = i
        elif abs(coefs[i]) > abs(coefs[third_best_index]):
            third_best_index = i


    print(features.columns[first_best_index], coefs[first_best_index])
    print(features.columns[second_best_index], coefs[second_best_index])
    print(features.columns[third_best_index], coefs[third_best_index])


FILEPATH = 'data_lab7.csv'
TRAIN_RATIO = 0.3

data = loader.load(FILEPATH)
warnings.filterwarnings('ignore')
verify(data, pd.read_csv('data_lab7_expanded.csv', low_memory=False))
linear_regression(data)
ridge_regression(data)
the_lasso(data)
