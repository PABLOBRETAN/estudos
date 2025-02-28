import styles from './task.module.css'

function Task (props) {
  

  return (
    <div className={styles.task}>
      {props.text}
    </div>
  )
}

export default Task