import React, {useState} from 'react';
import {makeStyles, Paper, Typography} from "@material-ui/core";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";


const useStyles = makeStyles(theme => ({
    marginInput: {
        margin: 10
    },
}));

function ForestForm(props) {
    const {
        requestData: [requestData, setRequestData]
    } = {
        ...(props.state || {})
    };

    const handleTextFieldChange = name => event => {
        setRequestData({...requestData, [name]: event.target.value});
    };

    const classes = useStyles();
    return (
        <div>
            <Paper>
                <Container>
                    <Typography variant={"h5"}>
                        Zmień parametry wyszukania
                    </Typography>
                    <Container>
                        <TextField
                            onChange={handleTextFieldChange('query')}
                            value={requestData.query}
                            id="query"
                            label="Wyszukaj"
                            type="text"
                            className={classes.marginInput}
                        />
                        <TextField
                            onChange={handleTextFieldChange('limit')}
                            value={requestData.limit}
                            id="limit"
                            label="Limit"
                            type="number"
                            className={classes.marginInput}
                        />
                    </Container>
                </Container>
            </Paper>
        </div>
    );
}

export default ForestForm;