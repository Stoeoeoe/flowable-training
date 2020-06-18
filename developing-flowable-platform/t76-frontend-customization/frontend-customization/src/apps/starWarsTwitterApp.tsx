import React from 'react';

import {TwitterTimelineEmbed} from 'react-twitter-embed/dist/index.js';         // External component
import {ExternalAppComponentProps} from '@flowable/work';

export type StarWarsTwitterAppProps = ExternalAppComponentProps & {};

// A simple example for an external app with no interaction with Flowable at all.
export const StarWarsTwitterApp = (props: StarWarsTwitterAppProps) => {
    return (<TwitterTimelineEmbed
        sourceType="list"
        ownerScreenName="starwars"
        slug="star-wars-cast-crew"
        options={{height: 800}}
    />);
};
