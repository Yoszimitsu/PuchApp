import React, {useEffect, useState} from 'react';
import {API_ADDRESS} from "../utils/constants";
import TextField from "@material-ui/core/TextField";
import InputLabel from "@material-ui/core/InputLabel";
import Select from "@material-ui/core/Select";
import MenuItem from "@material-ui/core/MenuItem";
import Button from "@material-ui/core/Button";
import {makeStyles, Typography} from "@material-ui/core";
import DateFnsUtils from '@date-io/date-fns';
import {DateTimePicker, MuiPickersUtilsProvider} from '@material-ui/pickers';
import formatISO from 'date-fns/formatISO'
import Container from "@material-ui/core/Container";


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

    const [selectedDate, setSelectedDate] = useState(props.state.requestData.dateFrom);

    const handleDateChange = date => {
        setSelectedDate(date);
        try {
            setRequestData({...requestData, dateFrom: formatISO(date)});
        } catch (err) {
            console.log(err);
        }
    };

    const classes = useStyles();
    return (
        <div>
            <Typography>
                Wskaż zakres dat
            </Typography>
            <Container maxWidth="sm">
                <div className={classes.marginInput}>
                    <MuiPickersUtilsProvider utils={DateFnsUtils}>
                        <DateTimePicker value={selectedDate}
                                        onChange={handleDateChange}
                                        autoOk
                                        ampm={false}
                                        label="Data pierszej rejestracji"
                                        />
                    </MuiPickersUtilsProvider>
                </div>
            </Container>
        </div>
    );
}

export default CarForm;