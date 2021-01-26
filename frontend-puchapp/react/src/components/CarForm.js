import React, {useState} from 'react';
import {makeStyles, Paper, Typography} from "@material-ui/core";
import DateFnsUtils from '@date-io/date-fns';
import {
    MuiPickersUtilsProvider,
    KeyboardDatePicker,
} from '@material-ui/pickers';
import formatISO from 'date-fns/formatISO'
import Container from "@material-ui/core/Container";
import TextField from "@material-ui/core/TextField";


const useStyles = makeStyles(theme => ({
    marginInput: {
        marginTop: 20,
        marginBottom: 20,
    },
    bigButton: {
        height: 60,
        marginTop: 20,
        marginBottom: 40
    }
}));

function CarForm(props) {
    const {
        requestData: [requestData, setRequestData]
    } = {
        ...(props.state || {})
    };

   const handleTextFieldChange = name => event => {
        setRequestData({...requestData, [name]: event.target.value});
    };


    const handleDateChange = name => date => {
        try {
            setRequestData({...requestData, [name]: formatISO(date)});
        } catch (err) {
            console.log(err);
        }
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
                        <MuiPickersUtilsProvider utils={DateFnsUtils}>
                            <KeyboardDatePicker
                                disableToolbar
                                variant="inline"
                                format="MM/dd/yyyy"
                                margin="normal"
                                id="date-picker-inline"
                                label="Początek zakresu"
                                value={requestData.dateFrom}
                                onChange={handleDateChange("dateFrom")}
                                KeyboardButtonProps={{
                                    'aria-label': 'change date',
                                }}
                            />
                            <KeyboardDatePicker
                                disableToolbar
                                variant="inline"
                                format="MM/dd/yyyy"
                                margin="normal"
                                id="date-picker-inline2"
                                label="Koniec zakresu"
                                value={requestData.dateTo}
                                onChange={handleDateChange("dateTo")}
                                KeyboardButtonProps={{
                                    'aria-label': 'change date',
                                }}
                            />
                        </MuiPickersUtilsProvider>
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

export default CarForm;