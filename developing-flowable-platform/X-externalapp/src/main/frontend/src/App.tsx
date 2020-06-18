import React from 'react';
import ComplaintForm from './complaint/ComplaintForm';
import './App.css';

function App() {
  return (

      <div className="bg-light">
          <div className="app container">
              <div className="py-5 text-center">
                  <ComplaintForm/>
              </div>
          </div>
      </div>
  );
}

export default App;
