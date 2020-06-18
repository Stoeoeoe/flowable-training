import React, {useEffect, useState} from 'react';

import './starWarsApp.scss'                         // Styling for component
import Crawl from 'react-star-wars-crawl';          // External Starwars Crawl component

import {ExternalAppComponentProps} from '@flowable/work';

export type StarWarsAppProps = ExternalAppComponentProps & {};

/*
 This is an example for a custom app which can show anything you want.
 Here, we select a random Star Wars movie and display it in the main content panel.
 The example uses the "functional" style of React components.
 */
export const StarWarsApp = (props: StarWarsAppProps) => {

    // Set the state of the component: The current film and all films.
    const [film, setFilm] = useState({title: "A new hope", episode_id: 4, opening_crawl: "It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy...."});
    const [films, setFilms] = useState({results: []});

    // Execute this rest call asynchronously and store a random movie inside the state.
    // In class-style React components, this would happen inside componentDidMount
    // In the future, data fetching will more likely be done in "Suspense" component
    useEffect(async () => {
        const response = await fetch('https://swapi.co/api/films');
        const films = await response.json();
        // select one at random...
        let theFilm = films.results[Math.floor(Math.random() * films.results.length)];
        setFilm(theFilm);
        setFilms(films);
    }, []);

    const title = `Episode ${film.episode_id}`;

    const crawl = <Crawl
        title={title}
        subTitle={film.title}
        text={film.opening_crawl}
    />;

    console.log("Current films and film", films, film);

    // Show a list of films
    let filmsList = films ? films.results.map((f: any) =>
        <li style={f.title === film.title ? {fontWeight: "bolder"}: {}} onClick={() => setFilm(films.results.filter((fi: any) => fi.title === f.title)[0])}>{f.title}</li>)
        : <div/>;

    // The actual rendering part: List and Crawl
    return (
        <>
            <ul>{filmsList}</ul>
            {film && film.episode_id > 0 ? crawl : <div/>}
        </>
    );
};
