"""
DataVisualization_Lab3_A01017545.py
Name: Jihyo Kim
Student Number: A01017545
"""

import pandas as pd
import matplotlib.pyplot as plt
import numpy as np
from sklearn.linear_model import LinearRegression
import math
import random


class AutomobileDataVisualization:
    def __init__(self):
        self._data = pd.read_csv('AutomobilePrice_Lab3Part1.csv')
        self._features = list(self._data.columns)
        self._qualitative_features = ['make', 'engine-type', 'fuel-type', 'symboling', 'body-style',
                                                     'engine-location', 'fuel-system', 'drive-wheels',
                                                     'num-of-doors', 'num-of-cylinders']
        self._quantitative_features = ['length', 'width', 'height', 'curb-weight',
                                             'compression-ratio', 'horsepower', 'peak-rpm',
                                             'engine-size', 'bore', 'stroke',
                                             'city-mpg', 'highway-mpg', 'wheel-base']

    @property
    def data(self):
        return self._data

    @property
    def features(self):
        return self._features

    @property
    def quantitative_features(self):
        return self._quantitative_features

    @property
    def qualitative_features(self):
        return self._qualitative_features

    def plot_automobile_price_distribution(self):
        """
        Plot a histogram and a box plot for automobile
        price distribution
        :return: None
        """
        plt.close('all')

        # Plot a histogram
        plt.subplot(1, 2, 1)
        plt.title('Car Price Distribution Plot')
        plt.hist(self.data['price'])
        plt.xlabel('Price')
        plt.ylabel('Number of Automobiles')

        # Plot a box-plot
        plt.subplot(1, 2, 2)
        plt.title('Car Price Spread')
        plt.boxplot(self.data['price'])
        plt.ylabel('Price')

        plt.show()

    def plot_charts_for_qualitative_feature(self, features):
        """
        Plot a bar graph for the number of cars by the feature,
        a scatter diagram for the price distribution by the feature,
        and a histogram for the average price by the feature.
        :param features: a list of features in string
        :return: None
        """

        plt.close('all')
        plt.tight_layout()
        plt.figure(figsize=(20, 40))
        num_of_rows = len(features)

        for i, feature in enumerate(features):
            plt.subplot(num_of_rows, 3, i * 3 + 1)
            plt.title('Number of Cars vs. {0}'.format(feature))
            plt.hist(self.data[feature])
            plt.xlabel(feature)
            plt.ylabel('Number of Cars')

            plt.subplot(num_of_rows, 3, i * 3 + 2)
            plt.title('Price vs. {0}'.format(feature))
            plt.scatter(self.data[feature], self.data.price)
            plt.xlabel(feature)
            plt.ylabel('Price')

            plt.subplot(num_of_rows, 3, i * 3 + 3)
            mean_price_by_feature = self.data.groupby(by=[feature]).mean().price
            plt.title('Average Price by {0}'.format(feature))
            plt.bar(self.data[feature].unique(), mean_price_by_feature)
            plt.xlabel(feature)
            plt.ylabel('Average Price')

        plt.show()

    def plot_charts_for_quantitative_feature(self, features):
        """
        Plot scatter diagrams for each feature given and price
        :param features: a list of features in string
        :return: None
        """
        plt.close('all')
        plt.figure(figsize=(10, 20))
        num_of_columns = 3
        num_of_rows = math.ceil(len(features) / num_of_columns)

        for i, feature in enumerate(features):
            plt.subplot(num_of_rows, num_of_columns, i + 1)
            plt.title('Price vs. {0}'.format(feature))
            plt.scatter(self.data[feature], self.data['price'])
            plt.xlabel(feature)
            plt.ylabel('Price')
        plt.show()

    def find_lowest_mae_in_price_prediction(self, features):
        """
        Find the lowest mean absolute error in the
        price prediction of an automobile using a linear regression.
        :param features: a list of features in string
        :return: A feature that has the lowest MAE in the price prediction
        """

        # some random large number
        lowest_mae = 10000000000

        feature_with_lowest_mae = ''
        for feature in features:
            data_subset = self.data.loc[:, [feature, 'price']]

            # Perform one-hot encoding if the feature given is
            # qualitative data (non-numeric values)
            if feature in self.qualitative_features:
                data_subset = pd.get_dummies(data_subset, columns=[feature],
                                             prefix=[feature])

            train_ratio = 0.75

            num_of_rows = data_subset.shape[0]
            shuffled_indices = list(range(num_of_rows))
            random.shuffle(shuffled_indices)

            train_set_size = int(num_of_rows * train_ratio)
            train_indices = shuffled_indices[:train_set_size]
            test_indices = shuffled_indices[train_set_size:]

            train_data = data_subset.iloc[train_indices, :]
            test_data = data_subset.iloc[test_indices, :]

            train_features = train_data.drop('price', axis=1, inplace=False)
            train_labels = train_data.loc[:, 'price']

            test_features = test_data.drop('price', axis=1, inplace=False)
            test_labels = test_data.loc[:, 'price']

            linear_regression = LinearRegression()
            linear_regression.fit(train_features, train_labels)
            pred = linear_regression.predict(test_features)

            mae = np.mean(np.abs(test_labels - pred))

            if mae < lowest_mae:
                lowest_mae = mae
                feature_with_lowest_mae = feature

            print('Mean Absolute Error for {0} = '.format(feature), mae)

        print('The feature that has the lowest MAE is {0}'.format(feature_with_lowest_mae))


def main():
    dv = AutomobileDataVisualization()
    dv.plot_automobile_price_distribution()
    dv.plot_charts_for_quantitative_feature(dv.quantitative_features)
    dv.plot_charts_for_qualitative_feature(dv.qualitative_features)

    dv.find_lowest_mae_in_price_prediction(dv.qualitative_features + dv.quantitative_features)


if __name__ == '__main__':
    main()
