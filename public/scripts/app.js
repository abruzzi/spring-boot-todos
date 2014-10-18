var Todos = Ember.Application.create();
Todos.ApplicationAdapter = DS.FixtureAdapter.extend();

Todos.Router.map(function() {
  this.resource('todos', {path: '/'})
});

Todos.Todo = DS.Model.extend({
    description: DS.attr('string')
});

Todos.Todo.FIXTURES = [
    {
        id:1,
        description: "Kill Bill"
    },
    {
        id:2,
        description: "Create a simple app based on ember"
    }
];

Todos.TodosController = Ember.ArrayController.extend({
    actions: {
        createTodo: function() {
            var description = this.get('description');
            if (!description) { return false; }
            if (!description.trim()) { return; }

            var todo = this.store.createRecord('todo', {
                description: description
            });

            this.set('description', '');

            todo.save();
        }
    }
});

Todos.TodosRoute = Ember.Route.extend({
    model: function() {
        return this.store.find('todo');
    }
});