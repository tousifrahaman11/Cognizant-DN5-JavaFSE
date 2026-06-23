# Exercise 7: Financial Forecasting (Recursive Algorithm)

## Scenario (Cognizant DN5.0 Handbook)
You are developing a financial forecasting tool that predicts future values
based on past data, using a recursive algorithm based on past growth rates.

## Requirements Implemented
- [x] Recursive algorithm (`growthFactorRecursive`) to predict future values
- [x] Forecast calculated as `presentValue * (1 + growthRate)^yearsAhead`,
      computed recursively instead of via `Math.pow()`
- [x] Optimized version using memoization (`growthFactorMemoized`) to avoid
      excessive recomputation

## How to Run
1. Open this folder in VS Code.
2. Open `src/FinancialForecastDemo.java`.
3. Click **Run** above `main` (or `Ctrl+F5`).

## Expected Output