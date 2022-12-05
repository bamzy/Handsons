'use strict';
const e = React.createElement;

class LikeButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = { liked: false };
    }

    render() {
        if (this.state.liked) {
            return 'You liked this.';
        }

        return e(
            'button',
            { onClick: () => this.setState({ liked: true }) },
            'Like'
        );
    }
}

class LoveButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = { liked: false };
    }

    render() {
        if (this.state.liked) {
            return 'You loved this.';
        }
        return (<div>hii</div>);
        return e(
            'button',
            { onClick: () => this.setState({ liked: true }) , className:"hi"},
            e('img',{src:'https://codecademy-prod.s3.amazonaws.com/profile_thumbnail/598aa9ff961baeacab0002ef_560996145.png',style:{width:40 +'px',height:40+'px'}},null)
        );
    }
}
export default LoveButton;