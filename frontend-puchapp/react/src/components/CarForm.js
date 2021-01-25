import React, {useState} from 'react';
import {makeStyles, Paper, Typography} from "@material-ui/core";
import DateFnsUtils from '@date-io/date-fns';
import {
    MuiPickersUtilsProvider,
    KeyboardDatePicker,
} from '@material-ui/pickers';
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
            <Paper>
                <Container>
                <Typography variant={"h5"}>
                    Zmień parametry wyszukania
                </Typography>
                <Container>
                    <div className={classes.marginInput}>
                        <MuiPickersUtilsProvider utils={DateFnsUtils}>
                            <KeyboardDatePicker
                                disableToolbar
                                variant="inline"
                                format="MM/dd/yyyy"
                                margin="normal"
                                id="date-picker-inline"
                                label="Data pierszej rejestracji"
                                value={selectedDate}
                                onChange={handleDateChange}
                                KeyboardButtonProps={{
                                    'aria-label': 'change date',
                                }}
                            />
                        </MuiPickersUtilsProvider>
                    </div>
                </Container>
                </Container>
            </Paper>
        </div>
    );
}

export default CarForm;