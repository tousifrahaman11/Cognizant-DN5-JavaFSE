import CohortDetails from './CohortDetails';

function App() {
  return (
    <div>
      <h1>My Academy — Cohort Dashboard</h1>
      <CohortDetails
        name="DN 5.0 Java FSE"
        batch="Batch 12"
        startDate="01-Jun-2026"
        endDate="31-Jul-2026"
        status="Ongoing"
      />
      <CohortDetails
        name="DN 4.0 Java FSE"
        batch="Batch 11"
        startDate="01-Jan-2026"
        endDate="28-Feb-2026"
        status="Completed"
      />
      <CohortDetails
        name="DN 3.0 Full Stack"
        batch="Batch 10"
        startDate="01-Sep-2025"
        endDate="30-Oct-2025"
        status="Completed"
      />
    </div>
  );
}

export default App;