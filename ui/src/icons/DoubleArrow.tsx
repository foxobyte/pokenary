import React from 'react';

interface DoubleArrowProps {
    direction: boolean
}

const DoubleArrow = (props: DoubleArrowProps) => (
    <svg
        height="100%"
        width="28px"
        viewBox="0 0 10 10"
        transform={props.direction ? "" : "rotate(180)"}
    >
        <path d="M 4 10 L 2 5 L 4 0" stroke="black" strokeLinecap="round" fill="none"/>
        <path d="M 6 10 L 4 5 L 6 0" stroke="black" strokeLinecap="round" fill="none"/>
    </svg>
)

export default DoubleArrow;