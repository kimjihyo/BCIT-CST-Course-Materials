"""
Name: Jihyo Kim
Student Number: A01017545
Set: 3M
"""


from GenData_Lab5 import genNoisyData, f
import numpy as np
from sklearn.preprocessing import PolynomialFeatures
from sklearn.linear_model import LinearRegression
from matplotlib import pyplot as plt

polynomials = [1, 3, 5, 9, 15]
number_of_batches = 1000
x_batches = []
y_batches = []

for i in range(number_of_batches):
    data = genNoisyData()
    x_batches.append(data[0])
    y_batches.append(data[1])

x_batches = np.array(x_batches)
y_batches = np.array(y_batches)

predictions = {}

for p in polynomials:
    predictions[p] = []
    for i in range(number_of_batches):
        # Generate nth degree polynomial features
        polynomial_features = PolynomialFeatures(degree=p)
        x_polynomial = polynomial_features.fit_transform(x_batches[i].reshape(-1, 1))

        # Train a model with the features
        model = LinearRegression()
        model.fit(x_polynomial, y_batches[i].reshape(-1, 1))
        
        # Predict f(5) with the model trained above
        prediction = model.predict(polynomial_features.fit_transform(np.array(5).reshape(-1, 1)))
        predictions[p].append(float(prediction))

biases = {}
variances = {}
average_predictions = {}

# Calculate biases and variances for each polynomial degree.
for p in polynomials:
    average_prediction = np.mean(predictions[p])
    average_predictions[p] = average_prediction
    biases[p] = abs(average_prediction - f(5))
    sum_of_distances_from_average_prediction = 0
    for prediction in predictions[p]:
        sum_of_distances_from_average_prediction += (prediction - average_prediction) ** 2
    variances[p] = sum_of_distances_from_average_prediction / number_of_batches

plt.figure(figsize=(20, 10))
for i, p in enumerate(polynomials):
    plt.subplot(2, 3, i + 1)
    plt.hist(predictions[p])
    plt.xlabel("y_pred(x=5)")
    plt.ylabel("Counts")
    plt.axvline(x=f(5), label="f(5)", color='r')
    plt.axvline(x=average_predictions[p], label="mean of y_pred(x=5)", color='g')
    plt.title("Histogram for p = " + str(p))
    plt.legend()

# Find the nth polynomial degree that yields the lowest bias and variance
lowest_bias = (0, 100000)
lowest_variance = (0, 100000)

for p in polynomials:
    if lowest_bias[1] > biases[p]:
        lowest_bias = (p, biases[p])
    if lowest_variance[1] > variances[p]:
        lowest_variance = (p, variances[p])
print('{0} degree polynomial has the lowest bias at {1}'.format(lowest_bias[0], lowest_bias[1]))
print('{0} degree polynomial has the lowest variance at {1}'.format(lowest_variance[0], lowest_variance[1]))
plt.show()

