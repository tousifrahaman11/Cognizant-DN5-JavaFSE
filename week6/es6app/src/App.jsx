function App() {

  const students = [
    { id: 1, name: 'Alice', grade: 'A' },
    { id: 2, name: 'Bob', grade: 'B' },
    { id: 3, name: 'Charlie', grade: 'A' },
    { id: 4, name: 'Diana', grade: 'C' },
  ];

  const getGradeColor = (grade) => {
    if (grade === 'A') return 'green';
    if (grade === 'B') return 'blue';
    return 'orange';
  };

  return (
    <div style={{ padding: '20px' }}>
      <h1>ES6 Features Demo</h1>

      <h2>1. Arrow Functions</h2>
      <p>Result: {(() => 'Hello from arrow function!')()}</p>

      <h2>2. map() Method</h2>
      <ul>
        {students.map((student) => (
          <li key={student.id} style={{ color: getGradeColor(student.grade) }}>
            {student.name} — Grade: {student.grade}
          </li>
        ))}
      </ul>

      <h2>3. Destructuring</h2>
      {students.map(({ id, name, grade }) => (
        <p key={id}>
          Student: <strong>{name}</strong>, Grade: <strong>{grade}</strong>
        </p>
      ))}

      <h2>4. const and let</h2>
      <p>const is block-scoped and cannot be reassigned.</p>
      <p>let is block-scoped and can be reassigned.</p>
    </div>
  );
}

export default App;