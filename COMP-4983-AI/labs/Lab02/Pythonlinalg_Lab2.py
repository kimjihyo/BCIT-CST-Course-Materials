"""
Lab Excercise #2
Name: Jihyo Kim
Student Number: A01017545
"""

import numpy as np
import math

A = np.array([
    [3, 2],
    [4, 1],
])

B = np.array([
    [0, -2],
    [4, 5],
])

C = np.array([
    [3, 0, 2],
    [4, 0, 1],
])

D = np.array([
    [6, 1, -5],
    [5, -2, 13],
])


def calculate(label, func):
    print(label)
    try:
        print(func())
    except:
        print("Can't compute")
    print("=" * 10)


def is_speical_matrix(m):
    is_neither = True
    if np.allclose(m.transpose(), m):
        print("Symmetric")
        is_neither = False
    if np.allclose(np.linalg.inv(m), m.transpose()):
        print("Orthogonal")
        is_neither = False
    if is_neither:
        print("Neither")
    print("=" * 10)


def calculate_manhattan_distance_from_origin(v):
    dist = 0
    for i in v:
        dist += abs(i)
    return dist


def calculate_euclidean_distance_from_origin(v):
    dist = 0
    for i in v:
        dist += i ** 2
    return math.sqrt(dist)


def main():
    # 1.a
    calculate("1.a, C^T", lambda: C.transpose())
    # 1.b
    calculate("1.b, A - 3I", lambda: A - 3 * np.eye(2))
    # 1.c
    calculate("1.c, 2A + B", lambda: 2 * A + B)
    # 1.d
    calculate("1.d, D^T - C", lambda: D.transpose() - C)
    # 1.e
    calculate("1.e, 2AB", lambda: np.dot(2 * A, B))
    # 1.f
    calculate("1.f, C^T * A", lambda: np.dot(C.transpose(), A))
    # 1.g
    calculate("1.g, A*B*D^T", lambda: np.dot(np.dot(A, B), D.transpose()))
    # 2.a
    calculate("2.a", lambda: np.linalg.inv(np.array([
        [0.3, 0.1],
        [-0.4, 0.2]
    ])))
    # 2.b
    calculate("2.b", lambda: np.linalg.inv(np.array([
        [0, 5],
        [1, 8]
    ])))
    # 2.c
    calculate("2.c", lambda: np.linalg.inv(np.array([
        [0.6, 0.3],
        [-1.6, -0.8]
    ])))
    # 3.a
    print("3.a")
    is_speical_matrix(np.array([
        [2/3, 1/3, 2/3],
        [-2/3, 2/3, 1/3],
        [1/3, 2/3, -2/3],
    ]))
    # 3.b
    print("3.b")
    is_speical_matrix(np.array([
        [-3, 1, 5],
        [2, 0, -2],
        [5, -2, 4],
    ]))
    # 3.c
    print("3.c")
    is_speical_matrix(np.eye(3))
    # 4.a
    calculate(
        "4.a", lambda: calculate_manhattan_distance_from_origin([4, 5, -2]))
    # 4.b
    calculate(
        "4.b", lambda: calculate_euclidean_distance_from_origin([4, 5, -2]))
    # 5.a
    calculate("5.a", lambda: np.linalg.solve(np.array([
        [2, 3],
        [3, 2],
    ]), np.array([4, -4])))
    # 5.b
    calculate("5.b", lambda: np.linalg.solve(np.array([
        [-1, 2],
        [3, 4],
    ]), np.array([4, 38])))

if __name__ == "__main__":
    main()
