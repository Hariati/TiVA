This is the core engine of the TiVA project.

For an overview of the TiVA project, see https://hariati.github.io/tiva-framework

For the TiVA DSL and its integration within the Eclipse IDE, see https://github.com/Hariati/Tiva-DSL.git

1. Requirements:

To use TiVA Core you can either: 

- Download the TiVA Core (executable jar file) which you can use directly.

- Or build the TiVA Core java project from sources.


TiVA Core (with the 'verifyta' file copied in the same folder) must be run from a location where you have the user rights (to create temporary files used by TiVA Core). You can run TiVA Core from your user folder for example.

2. Provided features:

The TiVA Core provides you with:

- Load, save, edit and translate (to XTA format) the DSL code.
- Load, save, edit and produce XTA format (sets of timed automata of your model).
- Load, save and edit your UPPAAL CTL properties for verification.
- Display and save the results of the verification (an internal call to UPPAAL Engine is performed).

Further, verifications and graphical simulations (for counter examples for instance) can also achieved from outside the TiVA Core using UPPAAL Tool (using the XTA file provided and saved by TiVA Core).

3. Operating systems:

TiVA Core is operational on Windows and Linux operating systems.

The 'verifyta' file provided here is for an execution under Windows operating system. To run TiVA Core on Linux, you just need to recover the 'verifyta' file corresponding to your operating system from this link: http://uppaal.org/

You have to download UPPAAL corresponding to your operating system. The 'verifyta' file is located in bin folder of the UPPAAL installation.

4. Examples:

Examples of models of systems to verify are available in the "examples" folder.

In progress...

A version of TiVA Core for Mac OS X will be available in a few days.



