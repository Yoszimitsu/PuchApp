import React from "react";
import { Grid, makeStyles } from "@material-ui/core";
const useStyles = makeStyles({
    appBar: {
        color: "#F2F2F3",
        backgroundColor: "#494E62"
    },
    titleAppBar: {
        padding: 10,
        marginLeft: 30
    }
});

function AppBar() {
    const classes = useStyles();
    return (
        <Grid
            container
            className={classes.appBar}
            justify={"flex-start"}
            alignItems={"center"}
        >
            <Grid item className={classes.titleAppBar}>
                <h1>PuchApp</h1>
            </Grid>
        </Grid>
    );
}

export default AppBar;