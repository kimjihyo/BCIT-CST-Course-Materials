"""
Name: Jihyo Kim
Student Number: A01017545
Set: 3M
"""



import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import warnings


def poly_kfoldCV(x, y, p, K):
    """
    k-fold cross-validation for polynomial regression
    Inputs:
    x: training input
    y: training output
    p: degree of fitting polynomial
    K: number of folds
    Outputs:
    train_error: average MAE of the training set across all K folds
    cv_error: average MAE for the validation set across all K folds
    """
    sum_cv_error = 0
    sum_train_error = 0

    nrows = x.shape[0]
    len_subset = int(nrows / K)

    # Noticed that when too few data points are given
    # to train high degree polynomial regression model,
    # Numpy prints warning messages.
    # So the line below supresses the verbose warnings.
    warnings.filterwarnings('ignore')


    for k in range(K):
        # Split dataset into K (k = 1, k = 2 ... k = K).
        # The kth dataset is for validation, and the rest is for training. 
        validation_set = x[len_subset * k: len_subset * (k + 1)]
        validation_label = y[len_subset * k: len_subset * (k + 1)]
        training_set = np.concatenate((x[0: len_subset * k], x[len_subset * (k + 1):]))
        training_label = np.concatenate((y[0: len_subset * k], y[len_subset * (k + 1):]))

        # Calculate weights for a model with pth polynomial degree.
        weights = np.polyfit(training_set, training_label, p)

        # Predict values against validation set. 
        cv_prediction = np.polyval(weights, validation_set)

        # Predict values against training set.
        train_prediction = np.polyval(weights, training_set)

        # Calculate Cross-Validation Mean Absolute Errors, and sum them up.
        sum_cv_error += np.mean(np.abs(validation_label - cv_prediction))

        # Calculate Training Mean Absoulte Errors, and sum them up.
        sum_train_error += np.mean(np.abs(training_label - train_prediction))
    
    # Calculate the average of train MAE.
    train_error = sum_train_error / K

    # Calculate the average of CV MAE.
    cv_error = sum_cv_error / K

    return train_error, cv_error


def part3(should_display_plot=True):
    # Read data from a CSV file.
    data = pd.read_csv('data_lab6.csv')
    results = [() for i in range(0, 15)]

    # Calculate training and cross-validation MAE for each polynomial degree (1st ~ 15th).
    for p in range(1, 16):
        results[p - 1] = poly_kfoldCV(data['x'], data['y'], p, 5)

    results_in_np_array = np.array(results)

    # Plot a line graph indicating changes in the both MAEs over the polynomial degrees.
    plt.plot(np.arange(1, 16), results_in_np_array[:,0], label='Train Error')
    plt.plot(np.arange(1, 16), results_in_np_array[:,1], label='CV Error')
    plt.xlabel('polynomial degree')
    plt.ylabel('error')
    plt.title('Part3: Train Error vs. Cross-Validation Error')
    plt.legend()

    # Find a model that did best on the validation set.
    min_cv_error = 10000
    polynomial_degree_of_model = -1
    for i, cv_error in enumerate(results_in_np_array[:,1]):
        if min_cv_error  > cv_error:
            min_cv_error = cv_error
            polynomial_degree_of_model = i + 1

    # The best model complexity is 5th polynomial degree.
    print('PART3:: The best model complexity is ' + str(polynomial_degree_of_model) + 'th polynomial degree.')
    print('This is because ' + str(polynomial_degree_of_model) + 'th polynomial degree yields the lowest cross-validation error')

    if should_display_plot:
        plt.show()

def part4(should_display_plot=True):
    # Read data from a CSV file.
    data = pd.read_csv('data_lab6.csv')
    
    plt.figure(figsize=(12, 10)).suptitle('Part4: Learning Curve. Train Error vs. Cross-Validation Error')
    plt.tight_layout()
    
    min_cv_error_when_50_samples = 100000000
    min_cv_error_when_80_samples = 100000000

    # The MAE for 50 samples is stored in results array at index of 6
    polynomial_degree_of_best_model_when_50_samples = -1
    
    # The MAE for 80 samples is stored in results array at index of 12
    polynomial_degree_of_best_model_when_80_samples = -1
    
    # Calculate learning curves over the number of samples
    # for each polynomial degree (2nd, 7th, 10th, 16th)
    for index, p in enumerate([2, 7, 10, 16]):
        results = [() for i in range(20, 105, 5)]
        for i in range(20, 105, 5):
            data_subset = data[:i]

            # Calculate training and cross-validation MAE for each sample size.
            results[int((i / 5) - 4)] = poly_kfoldCV(data_subset['x'], data_subset['y'], p, 5)
        
        results_in_np_array = np.array(results)

        # Find the minimum cross-validation error
        # when 50 and 80 samples are given respectively.
        if min_cv_error_when_50_samples > results_in_np_array[:,1][6]:
            min_cv_error_when_50_samples = results_in_np_array[:,1][6]
            polynomial_degree_of_best_model_when_50_samples = p
        if min_cv_error_when_80_samples > results_in_np_array[:,1][12]:
            min_cv_error_when_80_samples = results_in_np_array[:,1][12]
            polynomial_degree_of_best_model_when_80_samples = p

        # Plot line graphs for each polynomial degree
        # indicating changes in train and cross-validation error
        # over the number of samples (20, 25, 30 ... 100).
        plt.subplot(2, 2, index + 1)
        plt.plot(np.arange(20, 105, 5), results_in_np_array[:,0], label='Train Error')
        plt.plot(np.arange(20, 105, 5), results_in_np_array[:,1], label='CV Error')
        axes = plt.gca()
        axes.set_ylim([0,2])
        plt.title(str(p) + ' complexity')
        plt.xlabel('number of samples in data')
        plt.ylabel('error')
        plt.legend()

    print('PART4 (Step 3, a):: The model with 2nd polynomial degree has the highest bias.')
    print('This is because a model with lower complexity tends to have higher bias.')
    print('PART4 (Step 3, b):: The model with 16th polynomial degree has the highest variance.')
    print('This is because a model with higher complexity tends to have higher variance.')

    # The best model complexity when only 50 samples were given is 2nd polynomial degree.
    print('PART4 (Step 4, a):: The best model complexity when only 50 samples were given is ' 
        + str(polynomial_degree_of_best_model_when_50_samples) + 'th polynomial degree.')
    print('This is because it yields the lowest cross-validation error when only 50 samples are given.')

    # The best model complexity when only 80 samples were given is 7th polynomial degree.
    print('PART4 (Step 4, b):: The best model complexity when only 80 samples were given is ' 
        + str(polynomial_degree_of_best_model_when_80_samples) + 'th polynomial degree.')
    print('This is because it yields the lowest cross-validation error when only 80 samples are given.')

    if should_display_plot:
        plt.show()

        

def main():
    part3(should_display_plot=True)
    part4(should_display_plot=True)


if __name__ == '__main__':
    main()
