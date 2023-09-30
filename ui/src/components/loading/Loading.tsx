import React, { Component } from 'react';
import './loading.css';

export default class Loading extends Component {
    render() {
        return(
            <div className='loading'>
                <svg xmlns="http://www.w3.org/2000/svg" 
                    viewBox="0 0 248 248"
                >
                    <defs/>
                    <path id="shape0" transform="translate(5, 121.319996388192)" rx="118.2" ry="118.68" cx="118.2" cy="3.61180823296029e-06" end="3.14159268402296" d="M5.68434e-14 5.27045e-14C-1.28516e-06 42.4003 22.5288 81.5798 59.1 102.78C95.6712 123.98 140.729 123.98 177.3 102.78C213.871 81.5798 236.4 42.4003 236.4 3.61181e-06" fill="#ffffff" fillRule="evenodd" stroke="#000000" strokeWidth="9.6" strokeLinecap="square" strokeLinejoin="bevel"/>
                    <path id="shape0" transform="matrix(-1 0 0 -1 241.4 121.389597439629)" rx="118.2" ry="118.68" cx="118.2" cy="3.61180833863273e-06" end="3.14159268402296" d="M5.68434e-14 2.63425e-16C-1.28516e-06 42.4003 22.5288 81.5798 59.1 102.78C95.6712 123.98 140.729 123.98 177.3 102.78C213.871 81.5798 236.4 42.4003 236.4 3.61181e-06" fill="#ff0000" fillRule="evenodd" stroke="#000000" strokeWidth="9.6" strokeLinecap="square" strokeLinejoin="bevel"/>
                    <circle id="shape01" transform="matrix(1.02500002985166 0 0 1.02900002996815 81.2999995778517 84.2759993752349)" r="36" cx="36" cy="36" fill="#ffffff" fillRule="evenodd" stroke="#000000" strokeWidth="9.6" strokeLinecap="square" strokeLinejoin="bevel"/>
                    <path id="shape02" transform="matrix(1.02500002813247 0 0 1.02900002824225 156.539088842183 121.320000170885)" fill="none" stroke="#000000" strokeWidth="9.6" strokeLinecap="square" strokeLinejoin="miter" strokeMiterlimit="2" d="M0 0L77.4 0"/>
                    <path id="shape03" transform="matrix(1.02500001199866 0 0 1.02900001204549 1.10399670456068 121.319999965646)" fill="none" stroke="#000000" strokeWidth="9.6" strokeLinecap="square" strokeLinejoin="miter" strokeMiterlimit="2" d="M0 0L77.4 0"/>
                </svg>
            </div>
        )
    }
}