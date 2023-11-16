import React, { Component } from 'react';
import './battleStatsBox.css';

interface BattleStatsBoxProps {
    attacking: boolean,
    name: string,
    level: number,
    hp: number,
    gender: boolean
}

const BattleStatsBox = (props: BattleStatsBoxProps) => {
    return(
        <div className='battle-stats-box-wrapper'>
            <div className={`battle-stats-box-${props.attacking ? 'attacking' : 'defending'}`}>
                <div className='battle-stats-box-title-wrapper'>
                    <div className='battle-stats-box-name'>

                    </div>
                    <div className='battle-stats-box-gender'>

                    </div>
                    <div className='battle-stats-box-level'>

                    </div>
                </div>
                <div className='battle-stats-box-hp'>

                </div>
                <div className='battle-stats-box-xp'>

                </div>
            </div>
        </div>
    )
}

export default BattleStatsBox;