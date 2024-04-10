# SpreadSheet
Here are some Edge cases that need to be considered.
Invalid cell value: If a cell value is neither an integer nor a valid expression, it throws an IllegalArgumentException.
Circular references: This implementation does not handle circular references. It may result in an infinite loop or stack overflow.
Invalid expressions: This implementation assumes that expressions are simple additions of cell references or integers. It does not handle more complex expressions or error checking (e.g., division by zero, syntax errors).
Empty cells: This implementation does not explicitly handle empty cells. If a cell is referenced before being set, it will result in a NullPointerException. Handling empty cells would require additional logic.
