import CalculateScore from './CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore
        Name="John Doe"
        School="Cognizant Academy"
        Total={450}
        goal={500}
      />
    </div>
  );
}

export default App;