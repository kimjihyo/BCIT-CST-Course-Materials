import pandas as pd
import random
import numpy as np
from sklearn.svm import SVC
import matplotlib.pyplot as plt
from matplotlib.ticker import MaxNLocator

data = pd.read_csv('data_lab10.csv')
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

train_features = train_data.iloc[:, :-1]
train_labels = train_data.iloc[:, -1]
test_features = test_data.iloc[:, :-1]
test_labels = test_data.iloc[:, -1]

subset_size = int(train_features.shape[0] / 10)

C = [0.001, 0.001, 0.01, 0.1, 1.5, 10, 100]

cv_errors = []
lowest_cv_error = 100
best_c = 0.001

for c in C:
    sum_rss = 0
    for K in range(10):
        cv_test_features = train_features[subset_size *
                                              K: subset_size * (K + 1)]
        cv_test_labels = train_labels[subset_size *
                                          K: subset_size * (K + 1)]

        cv_train_features = np.concatenate((train_features[0: subset_size * K],
                                                train_features[subset_size * (K + 1):]))
        cv_train_labels = np.concatenate((train_labels[0: subset_size * K],
                                              train_labels[subset_size * (K + 1):]))
        model = SVC(C=c, kernel='linear')
        model.fit(cv_train_features, cv_train_labels)
        predicted = model.predict(cv_test_features)
        rss = np.sum((predicted - cv_test_labels)**2)
        sum_rss += rss
    cv_error = sum_rss / 10
    cv_errors.append(cv_error)
    if lowest_cv_error > cv_error:
        lowest_cv_error = cv_error
        best_c = c

print(best_c, lowest_cv_error)

model = SVC(C=best_c, kernel='linear')
model.fit(train_features, train_labels)
predicted = model.predict(test_features)
print(f'Error rate: {(np.sum(predicted != test_labels) / test_labels.shape[0]) * 100}%')

plt.plot([str(n) for n in C], cv_errors)
plt.xlabel('C')
plt.ylabel('CV Error')
plt.title('SVC CV Errors 10-fold CV')
plt.show()