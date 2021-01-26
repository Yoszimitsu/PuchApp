import React from "react";
import {makeStyles, Table, Typography} from "@material-ui/core";
import Container from "@material-ui/core/Container";

const useStyles = makeStyles(theme => ({
    noPadding: {
        padding: 0
    }
}));

function Forest(props) {
    const classes = useStyles();
    return (
        <Container className={classes.noPadding}>
            <Typography variant={"h5"}>
                Dzielnica: {props.forest.dzielnica}
            </Typography>
            <Typography>
                Obwód: {props.forest.obwód}
            </Typography>
            <Typography>
                Gatunek panujący: {props.forest.gat_panujacy}
            </Typography>
            <Typography>
                Podszyt: {props.forest.podszyt}
            </Typography>
            <Typography>
                Zadzrewienie: {props.forest.zadrzewienie}
            </Typography>
            <Typography>
                Bonitacja: {props.forest.bonitacja}
            </Typography>
        </Container>
    );
}

export default Forest