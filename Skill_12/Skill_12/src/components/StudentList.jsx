import { useEffect, useState } from "react";
import axios from "axios";
function StudentList() {
  const [students, setStudents] = useState([]);

  const fetchStudents = async () => {
    try {
      const res = await axios.get("http://localhost:8080/students");
      console.log(res.data); // 👈 DEBUG
      setStudents(res.data);
    } catch (error) {
      console.error(error);
    }
  };
  useEffect(() => {
    fetchStudents();
  }, []);
  return (
    <div>
      <h2>Student List</h2>

      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
          </tr>
        </thead>

        <tbody>
          {students.length === 0 ? (
            <tr>
              <td colSpan="4">No data found</td>
            </tr>
          ) : (
            students.map((s) => (
              <tr key={s.id}>
                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.email}</td>
                <td>{s.course}</td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
}

export default StudentList;