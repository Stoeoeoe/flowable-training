import React from 'react';
import { CaseInstance } from '@flowable/work';
import { Payload } from '@flowable/forms/Model';


type StarRatingHeaderProps = { caseInstance: CaseInstance; actions?: any; stages?: any; payload?: Payload };

class StarRating extends React.Component<StarRatingHeaderProps> {
    constructor(props: StarRatingHeaderProps) {
        super(props);
    }

    componentDidMount(): void {

    }


    render() {
        const caseInstance = this.props.caseInstance as any;
        return <>
            <div>{caseInstance.name}</div>
        </>
            ;
    }
}

export default StarRating;