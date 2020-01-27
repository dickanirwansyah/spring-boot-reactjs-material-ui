import React from 'react';
import './App.css';
import Navbar from './components/Navbar';
import Container from '@material-ui/core/Container';
import Router from './components/RouterComponent';

function App() {
  return (
    <div>
        <Navbar/>
        <Container>
            <Router/>
        </Container>
    </div>
  );
}

export default App;
