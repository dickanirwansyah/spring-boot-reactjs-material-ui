import React, { Component } from "react";
import Api from '../../services/Api';
import {
    Table, 
    TableBody, 
    TableCell,
    TableHead,
    TableRow,
    Button
 } from '@material-ui/core';
import CreateIcon from '@material-ui/icons/Create';
import DeleteIcon from '@material-ui/icons/Delete';
import Typography from '@material-ui/core/Typography';


class ListLeadsComponent extends Component {

    constructor(props){
        super(props)
        this.state = {
            arrayLeads: [],
            message: null
        }
        this.reloadLeadsList = this.reloadLeadsList.bind(this);
    }

    componentDidMount(){
        this.reloadLeadsList();
    }

    reloadLeadsList(){
        Api.fetchLeads().then((res) => {
            console.log("DATA LEADS : "+res.data.data)
            this.setState({arrayLeads : res.data.data})
        });
    }

    render() {
        return (
            <div>
                <Typography variant="h4" style={style}>Leads Details</Typography>
                <Button variant="contained" color="primary">
                    Add Leads
                </Button>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell>NAME</TableCell>
                            <TableCell>EMAIL</TableCell>
                            <TableCell></TableCell>
                            <TableCell></TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {this.state.arrayLeads.map(row =>
                            <TableRow key={row.id}>
                                <TableCell component="th" scope="row">
                                    {row.id}
                                </TableCell>
                                <TableCell>{row.name}</TableCell>
                                <TableCell>{row.email}</TableCell>
                                <TableCell align="right"><CreateIcon /></TableCell>
                                <TableCell align="right"><DeleteIcon /></TableCell>
                            </TableRow>
                        )}
                    </TableBody>
                </Table>
            </div>
        )
    }
}

const style = {
    display: 'flex',
    justifyContent: ''
}

export default ListLeadsComponent;