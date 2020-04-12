"""
Name: Jihyo Kim
Student Number: A01017545
Set: 3M
"""


import pandas as pd
import numpy as np
import random


def comp4983_lin_reg_fit(x: np.ndarray, y: np.ndarray):
    """
    Fit linear regression model
    :param x: training input, numpy array
    :param y: training label, numpy array
    :return: weights, estimated weights of the linear regression model
    """
    return np.dot(np.dot(np.linalg.inv(np.dot(x.transpose(), x)), x.transpose()), y)


def comp4983_lin_reg_predict(x: np.ndarray, w: np.ndarray):
    """
    Predict using the linear regression model
    :param x: test input, numpy array
    :param w: test label, numpy array
    :return: y, predicted output
    """
    return np.dot(x, w.transpose())


def train_and_test(given_features):
    """
    Train a model to predict automobile prices with given features
    :param given_features: a list of features
    :return: mean absolute error (MAE), root mean square error (rmse), coefficient of determination (cod)
    """
    data_subset = data.loc[:, given_features + ['price']]

    ones = np.ones([data_subset.shape[0], 1])
    data_subset.insert(0, 'bias', ones, True)

    # split the data into training set and test set
    # use 75 percent of the data to train the model and hold back 25 percent
    # for testing
    train_ratio = 0.75
    # number of samples in the data_subset
    num_rows = data_subset.shape[0]
    # shuffle the indices
    shuffled_indices = list(range(num_rows))
    random.seed(42)
    random.shuffle(shuffled_indices)

    # calculate the number of rows for training
    train_set_size = int(num_rows * train_ratio)

    # training set: take the first 'train_set_size' rows
    train_indices = shuffled_indices[:train_set_size]
    # test set: take the remaining rows
    test_indices = shuffled_indices[train_set_size:]

    # create training set and test set
    train_data = data_subset.iloc[train_indices, :]
    test_data = data_subset.iloc[test_indices, :]

    # prepare training features and training labels
    # features: all columns except 'price'
    # labels: 'price' column
    train_features = train_data.drop('price', axis=1, inplace=False)
    train_labels = train_data.loc[:, 'price']

    # prepare test features and test labels
    test_features = test_data.drop('price', axis=1, inplace=False)
    test_labels = test_data.loc[:, 'price']

    weights = comp4983_lin_reg_fit(train_features, train_labels)
    price_pred = comp4983_lin_reg_predict(test_features, weights)

    # compute mean absolute error
    # formula: MAE = mean of | y_i - y_i_pred |
    # where y_i is the i-th element of test_labels
    #       y_i_pred is the i-th element of the price_pred
    # Ref: https://en.wikipedia.org/wiki/Mean_absolute_error
    mae = np.mean(np.abs(test_labels - price_pred))

    # compute root means square error
    # formula: RMSE = square root of mean of ( y_i - y_i_pred )^2
    # Ref: https://en.wikipedia.org/wiki/Root-mean-square_deviation
    rmse = np.sqrt(np.mean(np.square(test_labels - price_pred)))

    # compute coefficient of determination (aka R squared)
    # formula: CoD = 1 - SSres/SStot, where
    # SSres = sum of squares of ( y_i - y_i_pred )
    # SStot = sum of squares of ( y_i - mean of y_i )
    # Ref: https://en.wikipedia.org/wiki/Coefficient_of_determination
    total_sum_sq = np.sum(np.square(test_labels - np.mean(test_labels)))
    res_sum_sq = np.sum(np.square(test_labels - price_pred))
    CoD = 1 - (res_sum_sq / total_sum_sq)
    return mae, rmse, CoD


data = pd.read_csv("AutomobilePrice_Lab4.csv")

features = list(data.columns)
features.remove('price')
num_features = len(features)
feature_pair_with_lowest_mae = []
lowest_mae = 1000000

r = train_and_test(features)
print('Result using all the features')
print('Mean absolute error: ' + str(r[0]))
print('Root means square error: ' + str(r[1]))
print('Coefficient of determination: ' + str(r[2]))


# Calculate the three numbers (MAE, RSME, COD) with each two features
# And find the two features that yield the lowest MAE
for i in range(num_features - 1):
    for j in range(i + 1, num_features):
        result = train_and_test([features[i], features[j]])
        mae = result[0]
        if mae < lowest_mae:
            lowest_mae = mae
            feature_pair_with_lowest_mae = [features[i], features[j]]

print('\nThe two features yielding the lowest MAE: ')
print(feature_pair_with_lowest_mae)
print('The lowest MAE:', lowest_mae)


