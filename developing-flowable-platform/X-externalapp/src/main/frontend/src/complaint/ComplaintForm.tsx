import React, {ChangeEvent, Component, FormEvent} from 'react';

type ComplaintFormProps = {

}

type ComplaintFormState ={
    name: string;
}

class ComplaintForm extends Component<ComplaintFormProps, ComplaintFormState> {
    constructor(props: ComplaintFormProps) {
        super(props);
        this.state = {name: ''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event: ChangeEvent<HTMLInputElement>) {
        this.setState({name: event.target.value});
    }

    handleSubmit(event: FormEvent<HTMLFormElement>) {
        alert('A name was submitted: ' + this.state.name);
        event.preventDefault();
    }

    render() {
        return (
            <>
                <h1>Add Complaint</h1>
                <form onSubmit={this.handleSubmit} className="form-group">
                    <label>
                        Name:
                        <input type="text" value={this.state.name} onChange={this.handleChange} />
                    </label>
                    <input type="submit" value="Submit" />
                </form>
            </>
        );
    }
}

export default ComplaintForm;