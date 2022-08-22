import "./App.css";
import Patient from "./components/Patient";
import PatientList from "./components/PatientList";
import NavigationBar from "./components/NavigationBar";
import Footer from "./components/Footer";
import MyAlert from "./components/MyAlert";
import Container from "react-bootstrap/Container";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { useState } from "react";

function App() {
  const [alert, setAlert] = useState(null);

  let showAlert = (type, message) => {
    setAlert({
      type: type,
      message: message,
    });
    setTimeout(() => {
      setAlert(null);
    }, 3000);
  };

  return (
    <div className="App">
      <Router>
        <NavigationBar />
        
        <Container>
          <Routes>
            <Route path="patient" element={<Patient showAlert={showAlert} />} />
            <Route
              path="patient/:patientId"
              element={<Patient showAlert={showAlert} />}
            />
            <Route
              path="listPatient"
              element={<PatientList showAlert={showAlert} />}
            />
          </Routes>
        </Container>
        <Footer />
      </Router>
    </div>
  );
}

export default App;