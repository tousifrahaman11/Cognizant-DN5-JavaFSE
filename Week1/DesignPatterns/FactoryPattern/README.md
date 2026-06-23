# Exercise 2: Factory Method Pattern — Document Management System

## Scenario (Cognizant DN5.0 Handbook)
You are developing a document management system that needs to create
different types of documents (e.g., Word, PDF, Excel). Use the Factory
Method Pattern to achieve this.

## Requirements Implemented
- [x] `Document` interface (common contract for all document types)
- [x] Concrete classes: `WordDocument`, `PdfDocument`, `ExcelDocument`
- [x] Abstract `DocumentFactory` with method `createDocument()`
- [x] Concrete factories: `WordDocumentFactory`, `PdfDocumentFactory`, `ExcelDocumentFactory`,
      each extending `DocumentFactory` and implementing `createDocument()`
- [x] Test class (`FactoryMethodTest`) demonstrates creating each document type

## How to Run
1. Open this folder in VS Code.
2. Open `src/FactoryMethodTest.java`.
3. Click **Run** above `main` (or press `Ctrl+F5`).

## Expected Output