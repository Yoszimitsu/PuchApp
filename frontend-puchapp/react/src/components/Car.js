import React from "react";
import {makeStyles, Table, Typography} from "@material-ui/core";
import Container from "@material-ui/core/Container";

const useStyles = makeStyles(theme => ({
    noPadding: {
        padding: 0
    }
}));

function Car(props) {
    const classes = useStyles();
    return (
        <Container className={classes.noPadding}>
            <Typography variant={"h5"}>
                Marka: {props.car.attributes.brand}
            </Typography>
            <Typography>
                Model: {props.car.attributes.model}
            </Typography>
            <Typography>
                Typ: {props.car.attributes.vehicleType}
            </Typography>
            <Typography>
                Pochodzenie: {props.car.attributes.vehicleOrigin}
            </Typography>
            <Typography>
                Data pierwszej rejestracji: {props.car.attributes.firstRegistrationDate}
            </Typography>
        </Container>
    );
}

export default Car