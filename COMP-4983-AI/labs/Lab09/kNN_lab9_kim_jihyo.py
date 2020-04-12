'''
Name: Jihyo Kim
Student#: A01017545
Set: 3M
'''

import pandas as pd
import numpy as np
import operator
from sklearn.neighbors import KNeighborsClassifier
import random
import matplotlib.pyplot as plt
from matplotlib.ticker import MaxNLocator


def euclidean_distance(v1, v2):
    '''
    Calculate Eudclidean distance between two vectors.
    '''
    return np.sqrt(np.sum(np.power(v1 - v2, 2)))


def kNN(x, Xtrain, Ytrain, K):
    num_data = Xtrain.shape[0]
    distances = []
    # Calculate distance between x and each sample in Xtrain.
    for i in range(0, num_data):
        distances.append((i, euclidean_distance(x, Xtrain[i])))

    # Sort the distances
    distances.sort(key=operator.itemgetter(1))
    predictions_dictionary = {}
    counter = 0
    predicted = -1

    for i in range(0, K):
        _predicted = Ytrain[distances[i][0]]
        if _predicted in predictions_dictionary:
            predictions_dictionary[_predicted] += 1
        else:
            predictions_dictionary[_predicted] = 1
        if counter < predictions_dictionary[_predicted]:
            counter = predictions_dictionary[_predicted]
            predicted = _predicted
    return predicted


def part2():
    print('PART 2-3')
    features = np.array([
        [1, 1],
        [2, 3],
        [3, 2],
        [3, 4],
        [2, 5]
    ])
    labels = np.array([0, 0, 0, 1, 1])
    counter = 0
    # Predict values using kNN implemented above
    for i in range(0, 5):
        Xtrain = np.concatenate((features[:i], features[i + 1:]))
        Ytrain = np.concatenate((labels[:i], labels[i+1:]))
        predicted = kNN(features[i], Xtrain, Ytrain, 3)
        print('Expected: ', labels[i], 'Predicted: ', predicted)
        if labels[i] != predicted:
            counter += 1
    print('LOOCV Error: ', counter / 5)

    # Predict values using sklearn
    counter = 0
    print('\nPART 2-4')
    model = KNeighborsClassifier(n_neighbors=3)
    for i in range(5):
        Xtrain = np.concatenate((features[:i], features[i + 1:]))
        Ytrain = np.concatenate((labels[:i], labels[i+1:]))
        model.fit(Xtrain, Ytrain)
        predicted = model.predict(np.array([features[i]]))[0]
        print('Expected: ', labels[i], 'Predicted: ', predicted)
        if labels[i] != predicted:
            counter += 1
    print('LOOCV Error: ', counter / 5)


def part3():
    print('\nPART 3')
    filepath = './data_lab9.csv'
    data = pd.read_csv(filepath)
    train_ratio = 0.75
    num_rows = data.shape[0]
    shuffled_indices = list(range(num_rows))
    random.seed(42)
    random.shuffle(shuffled_indices)

    train_set_size = int(num_rows * train_ratio)

    train_indices = shuffled_indices[:train_set_size]
    test_indices = shuffled_indices[train_set_size:]

    train_data = data.iloc[train_indices, :]
    test_data = data.iloc[test_indices, :]

    train_features = train_data.drop('digit', axis=1, inplace=False)
    train_labels = train_data.loc[:, 'digit']

    test_features = test_data.drop('digit', axis=1, inplace=False)
    test_labels = test_data.loc[:, 'digit']

    subset_size = int(train_features.shape[0] / 10)
    best_k = 0
    lowest_cv_error = 1
    cv_errors = []

    # For kth nearest neighbors
    for k in range(1, 22, 2):
        # Perform 10-folds cross validation
        cv_error = 0
        sum_cv_error = 0
        for K in range(10):
            cv_test_features = train_features[subset_size *
                                              K: subset_size * (K + 1)]
            cv_test_labels = train_labels[subset_size *
                                          K: subset_size * (K + 1)]

            cv_train_features = np.concatenate((train_features[0: subset_size * K],
                                                train_features[subset_size * (K + 1):]))
            cv_train_labels = np.concatenate((train_labels[0: subset_size * K],
                                              train_labels[subset_size * (K + 1):]))

            model = KNeighborsClassifier(n_neighbors=k)
            model.fit(cv_train_features, cv_train_labels)
            num_rows_cv_test_features = cv_test_features.shape[0]
            counter = 0
            for i in range(num_rows_cv_test_features):
                predicted = model.predict([cv_test_features.iloc[i, :]])[0]
                expected = cv_test_labels.iloc[i]
                if predicted != expected:
                    counter += 1
            sum_cv_error += counter / num_rows_cv_test_features
        cv_error = sum_cv_error / 10
        cv_errors.append(cv_error)
        print(f'k={k}, CV_Error: {cv_error}')
        if cv_error < lowest_cv_error:
            lowest_cv_error = cv_error
            best_k = k
    print(f'Best value of k: {best_k}, CV_Error: {lowest_cv_error}')

    counter = 0
    selected_model = KNeighborsClassifier(n_neighbors=best_k)
    for i in range(test_features.shape[0]):
        Xtrain = np.concatenate((test_features.iloc[:i, :], test_features.iloc[i+1:, :]))
        Ytrain = np.concatenate((test_labels.iloc[:i], test_labels.iloc[i+1:]))
        selected_model.fit(Xtrain, Ytrain)
        predicted = selected_model.predict([test_features.iloc[i, :]])[0]
        if test_labels.iloc[i] != predicted:
            counter += 1
    print('\nError on test set: ', counter / test_features.shape[0])



    fig, ax = plt.subplots(constrained_layout=True)
    ax.plot(range(1, 22, 2), cv_errors)
    ax.set_xticks(range(1, 22, 2))
    ax.set_xlabel('k')
    ax.set_ylabel('cv_error')
    ax.set_title('kth nearest neighbors cv errors for hand written digits predictions (10 folds CV)')
    plt.show()
if __name__ == '__main__':
    part2()
    part3()
