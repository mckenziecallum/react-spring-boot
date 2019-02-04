import React, {Component} from 'react';

import style from './BasicComponent.css';

export default class BasicComponent extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div id={style.appContent}>
                Lets make a change happen hello world
            </div>
        );
    }
}