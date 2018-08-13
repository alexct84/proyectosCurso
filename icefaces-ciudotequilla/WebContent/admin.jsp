<!--
  ~ Version: MPL 1.1/GPL 2.0/LGPL 2.1
  ~
  ~ "The contents of this file are subject to the Mozilla Public License
  ~ Version 1.1 (the "License"); you may not use this file except in
  ~ compliance with the License. You may obtain a copy of the License at
  ~ http://www.mozilla.org/MPL/
  ~
  ~ Software distributed under the License is distributed on an "AS IS"
  ~ basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
  ~ License for the specific language governing rights and limitations under
  ~ the License.
  ~
  ~ The Original Code is ICEfaces 1.5 open source software code, released
  ~ November 5, 2006. The Initial Developer of the Original Code is ICEsoft
  ~ Technologies Canada, Corp. Portions created by ICEsoft are Copyright (C)
  ~ 2004-2006 ICEsoft Technologies Canada, Corp. All Rights Reserved.
  ~
  ~ Contributor(s): _____________________.
  ~
  ~ Alternatively, the contents of this file may be used under the terms of
  ~ the GNU Lesser General Public License Version 2.1 or later (the "LGPL"
  ~ License), in which case the provisions of the LGPL License are
  ~ applicable instead of those above. If you wish to allow use of your
  ~ version of this file only under the terms of the LGPL License and not to
  ~ allow others to use your version of this file under the MPL, indicate
  ~ your decision by deleting the provisions above and replace them with
  ~ the notice and other provisions required by the LGPL License. If you do
  ~ not delete the provisions above, a recipient may use your version of
  ~ this file under either the MPL or the LGPL License."
  ~
  -->

<f:view xmlns:f="http://java.sun.com/jsf/core"
        xmlns:h="http://java.sun.com/jsf/html"
          xmlns:ui="http://java.sun.com/jsf/facelets"
        xmlns:ice="http://www.icesoft.com/icefaces/component">
<html>
	


    <head>
    	<title><h:outputText value="#{msjs.titulo}"/></title>
	<link href="pages/mycss.css" rel="stylesheet" type="text/css"/>
	<f:loadBundle basename="mensajes" var="msjs"/>

    </head>
    <body>
    <p>
 <h:graphicImage value="/pages/images/duke.gif"/>
<h:outputText value="#{msjs.bienvenida}" styleClass="enfasis"/>
<h:graphicImage value="/pages/images/duke.gif"/>
</p>

		<h:form>
				<ice:outputConnectionStatus/><h:outputText value="#{ciudadAsyncBean.hora}"/>
		</h:form><!--


        <h:form>

			<p>
		 Propiedad del bean mediante la que se captura el value del elemento seleccionado
		<ice:selectOneMenu value="#{ciudadAsyncBean.ciudad.idCiudad}">
			<f:selectItems  value="#{ciudadAsyncBean.ciudadesLista}" />
		</ice:selectOneMenu>
		</p>
		</h:form>
			--><h:form>
			   <ice:dataTable id="data"
                 var="ciudad"
                 value="#{ciudadAsyncBean.ciudades}"
                    >
                    <!--
                    <ice:panelGroup draggable="true" dragOptions="revert,ghosting" dropValue="#{ciudad.idCiudad}"
          dragListener="#{ciudadAsyncBean.delCiudad}"
           dragMask="dragging,drag_cancel,hover_start,hover_end"
                dropMask="dragging,drag_cancel,hover_start,hover_end">

			        -->
			        <ice:column>
			        <ice:panelGroup draggable="true" dragOptions="revert,ghosting" dropValue="#{ciudad.idCiudad}"
          dragListener="#{ciudadAsyncBean.delCiudad}"
           dragMask="dragging,drag_cancel,hover_start,hover_end"
                dropMask="dragging,drag_cancel,hover_start,hover_end">
			            <f:facet name="header">
			                  <ice:outputText value="Id" />
			           </f:facet>
							 <h:graphicImage url="ciudad.png" />
			             </ice:panelGroup>
			        </ice:column>


			        <ice:column>

						<f:facet name="header">
			                  <ice:outputText value="Id" />
			            </f:facet>


			            	<ice:outputText value="#{ciudad.idCiudad}" />

			         </ice:column>

			        <ice:column>
			            <f:facet name="header">
			                  <ice:outputText value="Nombre" />
			           </f:facet>
			           <h:commandLink action="#{beanCiudad.paramEditar}">
			           		<f:param name="idCiudad" value="#{ciudad.idCiudad}"/>
			            	<ice:outputText value="#{ciudad.nombreCiudad}" />
			           </h:commandLink>
			        </ice:column>
<!--			</ice:panelGroup>-->
    </ice:dataTable>
			  <h:inputText value="#{ciudadAsyncBean.ciudad.nombreCiudad}" size="30" maxlength="30"/>
              <h:commandButton value="crear" action="#{ciudadAsyncBean.create}" />
              <br/>
              <br/>
              <br/>
              <ice:panelGroup width="50" length="50" dropTarget="true">
 					 <h:graphicImage  width="50" length="50" url="/trash.jpg" align="rigth"/>
				</ice:panelGroup>
			</h:form>
			<!--

    --></body>
</html>
</f:view>
