import pandas as pd
import numpy as np


def load(filepath):
    """
    Load and encode categorical data
    Inputs:
    filepath: path to the csv file
    Outputs:
    data: a DataFrame object containing encoded data
    """
    data = pd.read_csv(filepath, low_memory=False)
    categorical_features = get_categorical_data(data)
    data = pd.get_dummies(data, columns=categorical_features)

    for column in data.columns:
        if np.dtype(data[column]) == np.uint8:
            data[column] = data[column].astype(np.int64)

    return data


def get_categorical_data(data):
    """
    Get columns whose dtype is object or the number of unique values os less than 20
    Inputs:
    Pandas DataFrame
    Outputs:
    List of columns in str
    """
    categorical_features = []
    for column in data.columns:
        if np.dtype(data[column]) == object:
            categorical_features.append(column)
        elif data[column].nunique() < 20:
            categorical_features.append(column)
    return categorical_features


if __name__ == '__main__':
    load('data_lab7.csv')
