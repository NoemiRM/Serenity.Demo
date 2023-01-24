# serenity.pageObject

_Ejecutar por ambiente_<br/>
`$ mvn verify -Denvironment=dev`<br/>
_Ejecutar todos los escenarios_<br/>
`$ mvn verify`<br/>
_Ejecutar escenarios especificos_<br/>
`$ mvn verify -Dcucumber.options="--tags @functional=smoke"`<br/>
_Ejecutar varios escenarios especificos_<br/>
mvn verify -Dcucumber.options="--tags @happy-path-create,@happy-path-close"

