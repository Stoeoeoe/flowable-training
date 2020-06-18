import React from 'react';
import {Payload} from '@flowable/forms/Model';
import { CaseInstance, Task } from '@flowable/work';
import StarRating from "./StarRating";

type CaseHeaderData = { caseInstance: CaseInstance; actions?: any; stages?: any; payload?: Payload };
type TaskHeaderData = { task: Task; actions?: any; stages?: any; payload?: Payload };

type HeaderCustomizations = {
    cases?: { [index: string]: (props: CaseHeaderData) => JSX.Element },
    tasks?: { [index: string]: (props: TaskHeaderData) => JSX.Element }
}

export function getHeaderCustomizations(): HeaderCustomizations {
    let customizations: HeaderCustomizations = {
        cases: getCaseHeaderCustomizations(),
        tasks: getTaskHeaderCustomizations()
    };
    return customizations;
}

function getCaseHeaderCustomizations()  {
    return {
        'global': (props: CaseHeaderData) => {
            console.log("Rendering custom case header", props);
            return (
                <StarRating caseInstance={props.caseInstance}/>
            );
        }
    };
}

function getTaskHeaderCustomizations() {
    return {
        myTask: (props: TaskHeaderData) => {
            console.log(props);
            return (
                <div>
                    <div>my custom TASK header for casePageModel changed</div>
                    { /*
                    <div>{props.task ? props.task.name : props.payload?.caseInstanceId}</div> */
                    }
                </div>
            );
        }
    };
};