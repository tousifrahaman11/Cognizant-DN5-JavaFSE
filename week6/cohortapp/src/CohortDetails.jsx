import styles from './CohortDetails.module.css';

function CohortDetails(props) {
  const statusClass = props.status === 'Ongoing'
    ? styles['status-ongoing']
    : styles['status-completed'];

  return (
    <div className={styles.box}>
      <h3>{props.name}</h3>
      <p><strong>Batch:</strong> {props.batch}</p>
      <p><strong>Start Date:</strong> {props.startDate}</p>
      <p><strong>End Date:</strong> {props.endDate}</p>
      <p><strong>Status:</strong>
        <span className={statusClass}> {props.status}</span>
      </p>
    </div>
  );
}

export default CohortDetails;