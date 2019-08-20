# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import numpy as np

import pandas as pd 
import matplotlib.pyplot as plt

dataset = pd.read_csv('Bidholi.csv')
X = dataset.iloc[:, :-1].values
Y = dataset.iloc[:, 2].values
#from sklearn.preprocessing import LabelEncoder, OneHot
from sklearn.model_selection  import train_test_split
X_train, X_test, Y_train, Y_test = train_test_split(X,Y,test_size = 0.2,random_state = 0)
from sklearn.linear_model import LinearRegression
regressor = LinearRegression() 
regressor.fit(X_train, Y_train)
Y_pred = regressor.predict(X_test)
Y_pred_train = regressor.predict(X_train)
#Backward Elimination
import statsmodels.formula.api as sm
X = np.append(arr = np.ones((24,1)).astype(int),values = X, axis = 1)
X_opt = X[:, [0,1,2]]
regressor_OLS = sm.OLS(endog = Y, exog = X_opt).fit()
regressor_OLS.summary()
plt.scatter(X_train, Y_train, color = 'red')
plt.plot(X_train, regressor.predict(X_train), color = 'blue')
plt.title('Accident Prediction')
plt.xlabel('Time/Vehicles')
plt.ylabel('Accidents')
plt.show()
