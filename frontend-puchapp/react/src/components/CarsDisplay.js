import React, {useEffect, useState} from "react";
import axios from "axios";
import {API_ADDRESS} from "../utils/constants";
import Container from "@material-ui/core/Container"
import List from "@material-ui/core/List";
import {makeStyles, Paper, Typography} from "@material-ui/core";
import Divider from "@material-ui/core/Divider";
import ListItem from "@material-ui/core/ListItem";
import Car from "./Car";
import CarForm from "./CarForm";
import formatISO from "date-fns/formatISO";

const useStyles = makeStyles(theme => ({
    title: {
        marginTop: 20,
        marginBottom: 20
    },
    fab: {
        margin: 0,
        top: "auto",
        right: 50,
        bottom: 50,
        left: "auto",
        position: "fixed"
    },
    minPadding: {
        padding: 10
    }
}));

function CarsDisplay() {
    const [carsListItems, setCarsListItems] = useState([]);

    const [requestData, setRequestData] = useState({
        limit: 0,
        page: 0,
        dateFrom: "2018-04-20T00:00:00",
        dateTo: ""
    });

    useEffect(() => {
        axios.get(API_ADDRESS + "cepik/vehicles?dateFrom=" + requestData.dateFrom.substring(0,10) + "&dateTo=2018-04-21&limit=5&page=1&voivodeshipCode=14", {
        })
            .then(function (response) {
                setCarsListItems(response.data.data);
                console.log("Cars loaded, status: " + response.status)
            })
            .catch(function (error) {
                console.log("Something went wrong");
            });
    }, [requestData]);

    const classes = useStyles();
    return (
        <Container maxWidth="lg" className={classes.minPadding}>
            <CarForm state={{requestData: [requestData, setRequestData]}}/>
            <Typography className={classes.title} variant={"h5"}>
                Wczytane pojazdy
            </Typography>
            <Paper>
                <List>
                    {carsListItems.length === 0 ? (<h3 align={"center"}>Brak wczytanych pojazdów</h3>) : null}

                    {carsListItems.map((carListItem, index) => (
                        <div key={carListItem.id}>
                            <ListItem>
                               <Car car={carListItem}/>
                            </ListItem>
                            {index !== carsListItems.length - 1 ? (<Divider/>) : null}
                        </div>
                    ))}
                </List>
            </Paper>
        </Container>
    );
}

export default CarsDisplay;
