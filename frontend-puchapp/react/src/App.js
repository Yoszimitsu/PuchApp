import React from 'react';
import CarsDisplay from "./components/CarsDisplay";
import ForestDisplay from "./components/ForestDisplay";
import Grid from "@material-ui/core/Grid";
import CssBaseline from "@material-ui/core/CssBaseline";
import AppBar from "./components/AppBar";

function App() {
    return (
        <Grid
            container
            justify={"center"}
            style={{ backgroundColor: "#F2F3F6" }}
        >
            <CssBaseline />
            <Grid item xs={12} className={"appBarContainer"}>
                <header>
                    <AppBar />
                </header>
            </Grid>
            <Grid item xs={12} md={8} className={"appContainer"}>
                <main>
                    <CarsDisplay/>
                    <ForestDisplay/>
                </main>
            </Grid>
        </Grid>
    );
}

export default App;
