import React, {useEffect, useState} from "react";
import axios from "axios";
import {API_ADDRESS} from "../utils/constants";
import Container from "@material-ui/core/Container"
import List from "@material-ui/core/List";
import {makeStyles, Paper, Typography} from "@material-ui/core";
import Divider from "@material-ui/core/Divider";
import ListItem from "@material-ui/core/ListItem";
import Forest from "./Forest";
import ForestForm from "./ForestForm.js";
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

function ForestDisplay() {
    const [forestsListItems, setForestsListItems] = useState([]);

    const [requestData, setRequestData] = useState({
        query: "Kabaty",
        limit: 3
    });

    useEffect(() => {
        axios.get(API_ADDRESS + "forest?limit=" + requestData.limit + "&q=" + requestData.query + "&resource_id=75bedfd5-6c83-426b-9ae5-f03651857a48" , {
        })
            .then(function (response) {
                setForestsListItems(response.data.forestData);
                console.log("Forests loaded, status: " + response.status)
            })
            .catch(function (error) {
                console.log("Something went wrong");
            });
    }, [requestData]);

    const classes = useStyles();
    return (
        <Container maxWidth="lg">
            <Typography className={classes.title} variant={"h3"}>
                API Lasy
            </Typography>

            <ForestForm state={{requestData: [requestData, setRequestData]}}/>
            <Typography className={classes.title} variant={"h5"}>
                Wczytane lasy
            </Typography>
            <Paper>
                <List>
                    {forestsListItems.length === 0 ? (<h3 align={"center"}>Brak wczytanych lasów</h3>) : null}

                    {forestsListItems.map((forestListItem, index) => (
                        <div key={forestListItem._id}>
                            <ListItem>
                                <Forest forest={forestListItem}/>
                            </ListItem>
                            {index !== forestsListItems.length - 1 ? (<Divider/>) : null}
                        </div>
                    ))}
                </List>
            </Paper>
        </Container>
    );
}

export default ForestDisplay;
