<?php

namespace App\Http\Controllers;

use App\Http\Requests\ContactRequest;
use App\Notifications\ContactFormNotification;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Notification;
use Illuminate\Support\Facades\Storage;

class HomeController extends Controller
{
    /**
     * Show the application dashboard.
     *
     * @return \Illuminate\Contracts\Support\Renderable
     */
    public function index()
    {
        return view('home');
    }

    public function submit(ContactRequest $request)
    {
        Notification::route('mail', config('mail.contact_email'))
                    ->notify(new ContactFormNotification($request->only(['name', 'email', 'question'])));
        if($request->hasFile('cover')){

            //Storage::delete('/public/avatars/'.$user->avatar);

            // Get filename with the extension
            $filenameWithExt = $request->file('cover')->getClientOriginalName();
            //Get just filename
            $filename = pathinfo($filenameWithExt, PATHINFO_FILENAME);
            // Get just ext
            $extension = $request->file('cover')->getClientOriginalExtension();
            // Filename to store
            $fileNameToStore = $filename.'_'.time().'.'.$extension;
            // Upload Image
            $path = $request->file('cover')->storeAs('public/avatars',$fileNameToStore);
            // die($path);
        }
        return response()->noContent();
    }

    public function postContact(ContactRequest $request)
    {
        Notification::route('mail', config('mail.contact_email'))
            ->notify(new ContactFormNotification($request->only(['name', 'email', 'question'])));

        return back()->withMessage('Email successfully sent');
    }
}
