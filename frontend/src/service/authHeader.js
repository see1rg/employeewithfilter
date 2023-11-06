export const getAuthHeader = () => {
    const token = 'Basic qwerasdfzxcv';
    return {
        headers: {
            Authorization: token,
        },
    };
};
