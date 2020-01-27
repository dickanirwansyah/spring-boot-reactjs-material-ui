import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import React from 'react'
import ListComponent from './leads/ListLeadsComponent';

const AppRouter = () => {
    return (
    <div style={style}>
        <Router>
            <Switch>
                <Route path="/" exact component={ListComponent}></Route>
                <Route path="/leads" exact component={ListComponent}></Route>
            </Switch>
        </Router>
    </div>)
}

const style = {
    marginTop: '20px'
}

export default AppRouter;