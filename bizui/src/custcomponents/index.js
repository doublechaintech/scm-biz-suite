//import {TaskUpdateForm} from '../bizcomponents'
//import TaskUpdateFormDefault from './task/Task.updateform'
import OOTBComponents from '../bizcomponents'
import CustomComponents from './customindex'

import ExtraRouter from './customrouter'

//console.log("the ootb result", OOTBComponents);
const GlobalComponents = {...OOTBComponents,...CustomComponents,ExtraRouter};





//console.log("the cust result", GlobalComponents);
export default GlobalComponents;

