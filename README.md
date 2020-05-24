This is the core engine of the TiVA project.

For an overview of the TiVA project, see https://hariati.github.io/tiva-framework

For the TiVA DSL and its integration within the Eclipse IDE, see https://github.com/Hariati/Tiva-DSL.git

1. Requirements:

To use TiVA Core you can either: 

- Download the TiVA Core (executable jar file) which you can use directly.

- Or build the TiVA Core java project from sources.

2. Provided features:

The TiVA Core provides you with:

- Load, save, edit and translate (to XTA format) the DSL code.
- Load, save, edit and produce XTA format (sets of timed automata of your model).
- Edit your UPPAAL CTL properties for verification.
- Display the results of the verification (an internal call to UPPAAL Engine is performed).

Further, verifications and graphical simulations (for counter exemples for instance) can also achieved from outside the TiVA Core using UPPAAL Tool (using the XTA file provided and saved by TiVA Core).

3. Examples:

Examples of models of systems to verify are available in the "examples" folder.