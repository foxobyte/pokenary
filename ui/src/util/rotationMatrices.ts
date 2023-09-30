const rotationMatrices = {
    Y: function(degrees: number): number[][] {
        const radians = degrees * (Math.PI / 180);

        return [
            [Math.cos(radians), 0, Math.sin(radians), 0],
            [0, 1, 0, 0],
            [-Math.sin(radians), 0, Math.cos(radians), 0],
            [0, 0, 0, 1]
        ];
    },
    X: function(degrees: number): number[][] {
        const radians = degrees * (Math.PI / 180);

        return [
            [1, 0, 0, 0],
            [0, Math.cos(radians), -Math.sin(radians), 0],
            [0, Math.sin(radians), Math.cos(radians), 0],
            [0, 0, 0, 1]
        ]
    },
    Z: function(degrees: number): number[][] {
        const radians = degrees * (Math.PI / 180);

        return [
            [Math.cos(radians), -Math.sin(radians), 0, 0],
            [Math.sin(radians), Math.cos(radians), 0, 0],
            [0, 0, 1, 0],
            [0, 0, 0, 1]
        ]
    }
}

export default rotationMatrices;