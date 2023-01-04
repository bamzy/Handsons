import { useRouteError } from "react-router-dom";

export default function ErrorPage() {
    const error = useRouteError();


    return (
        <div className="error-page">
            <div className="">
                <h1>Oops!</h1>
                <p>Sorry, an unexpected error has occurred.</p>
                <p>
                    <i>{error.statusText || error.message}</i>
                </p>
            </div>
        </div>
    );
}