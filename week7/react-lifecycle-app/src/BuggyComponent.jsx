function BuggyComponent() {
  throw new Error("Intentional crash to demonstrate componentDidCatch");
}
export default BuggyComponent;